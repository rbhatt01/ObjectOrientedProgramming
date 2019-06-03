import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LogAnalyzer
{
      //constants to be used when pulling data out of input
      //leave these here and refer to them to pull out values
   private static final String START_TAG = "START";
   private static final int START_NUM_FIELDS = 3;
   private static final int START_SESSION_ID = 1;
   private static final int START_CUSTOMER_ID = 2;
   private static final String BUY_TAG = "BUY";
   private static final int BUY_NUM_FIELDS = 5;
   private static final int BUY_SESSION_ID = 1;
   private static final int BUY_PRODUCT_ID = 2;
   private static final int BUY_PRICE = 3;
   private static final int BUY_QUANTITY = 4;
   private static final String VIEW_TAG = "VIEW";
   private static final int VIEW_NUM_FIELDS = 4;
   private static final int VIEW_SESSION_ID = 1;
   private static final int VIEW_PRODUCT_ID = 2;
   private static final int VIEW_PRICE = 3;
   private static final String END_TAG = "END";
   private static final int END_NUM_FIELDS = 2;
   private static final int END_SESSION_ID = 1;

      //a good example of what you will need to do next
      //creates a map of sessions to customer ids
   private static void processStartEntry(
      final String[] words,
      final Map<String, List<String>> sessionsFromCustomer)
   {
      if (words.length != START_NUM_FIELDS)
      {
         return;
      }

         //check if there already is a list entry in the map
         //for this customer, if not create one
      List<String> sessions = sessionsFromCustomer
         .get(words[START_CUSTOMER_ID]);
      if (sessions == null)
      {
         sessions = new LinkedList<>();
         sessionsFromCustomer.put(words[START_CUSTOMER_ID], sessions);
      }

         //now that we know there is a list, add the current session
      sessions.add(words[START_SESSION_ID]);
   }

      //similar to processStartEntry, should store relevant view
      //data in a map - model on processStartEntry, but store
      //your data to represent a view in the map (not a list of strings)
   private static void processViewEntry(final String[] words,
                                        final Map<String, List<View>> sesssionsFromProduct)
   {
      if(words.length != VIEW_NUM_FIELDS) {
         return;
      }
      View view = new View(words[VIEW_PRODUCT_ID], VIEW_PRICE);
      List<View> views = sesssionsFromProduct.get(words[VIEW_SESSION_ID]);
      if(views == null) {
         views = new LinkedList<>();
         sesssionsFromProduct.put(words[VIEW_SESSION_ID], views);
      }
      views.add(view);

   }

      //similar to processStartEntry, should store relevant purchases
      //data in a map - model on processStartEntry, but store
      //your data to represent a purchase in the map (not a list of strings)
   private static void processBuyEntry(final String[] words, final Map<String, List<Buy>>sessionsFromProduct
      /* add parameters as needed */
      )
   {
      if(words.length != BUY_NUM_FIELDS) {
         return;
      }
      Buy buy = new Buy(words[BUY_PRODUCT_ID], BUY_PRICE, BUY_QUANTITY);
      List<Buy> sessions = sessionsFromProduct.get(words[BUY_SESSION_ID]);
      if(sessions == null) {
         sessions = new LinkedList<>();
         sessionsFromProduct.put(words[BUY_SESSION_ID], sessions);
      }
      sessions.add(buy);
   }

   private static void processEndEntry(final String[] words)
   {
      if (words.length != END_NUM_FIELDS)
      {
         return;
      }

   }

      //this is called by processFile below - its main purpose is
      //to process the data using the methods you write above
   private static void processLine(final String line,
      final Map<String, List<String>> sessionsFromCustomer,
                                   final Map<String, List<Buy>> sessionsFromBuy,
                                   final Map<String, List<View>> sessionsFromView)
   {
      final String[] words = line.split("\\h");

      if (words.length == 0)
      {
         return;
      }

      switch (words[0])
      {
         case START_TAG:
            processStartEntry(words, sessionsFromCustomer);
            break;
         case VIEW_TAG:
            processViewEntry(words, sessionsFromView);
            break;
         case BUY_TAG:
            processBuyEntry(words, sessionsFromBuy);
            break;
         case END_TAG:
            processEndEntry(words /* add arguments as needed */ );
            break;
      }
   }

      //write this after you have figured out how to store your data
      //make sure that you understand the problem
   private static void printSessionPriceDifference(final Map<String, List<String>> sessionsFromCustomer,
                                                   final Map<String, List<View>> viewsFromSession,
                                                   final Map<String, List<Buy>> buysFromSession)
   {
      System.out.println("Average Views without Purchase: " + AverageViewsWithoutPurchase(viewsFromSession, buysFromSession));
      System.out.println();
      System.out.println("Price Difference for Purchased Product by Session");

      /* add printing */
      for (String key: buysFromSession.keySet()){
         System.out.println(key);
         for(int i = 0; i < buysFromSession.get(key).size(); i++) {
            System.out.println(" "+ buysFromSession.get(key).get(i).getProductId()+ " "+ (buysFromSession.get(key).get(i).getPrice()-
                    AverageViewsWithoutPurchase(viewsFromSession, buysFromSession)));
         }
      }
   }

   private static double AverageViewsWithoutPurchase(final Map<String, List<View>> viewsFromSession,
                                                     final Map<String, List<Buy>> buysFromSession){
      double totalViews = 0;
      double noPurchase = 0;
      for(String key: viewsFromSession.keySet()) {
         if(!buysFromSession.containsKey(key)) {
            noPurchase++;
            totalViews += viewsFromSession.get(key).size();
         }
      }
      double ans = totalViews / noPurchase;
      return ans;
   }

      //write this after you have figured out how to store your data
      //make sure that you understand the problem
   private static void printCustomerItemViewsForPurchase(final Map<String, List<String>> sessionsFromCustomer,
                                                         final Map<String, List<View>> viewsFromSession,
                                                         final Map<String, List<Buy>> buysFromSession)
   {
      System.out.println("Number of Views for Purchased Product by Customer");

      /* add printing */
      for(String session: buysFromSession.keySet()) {
         for(int i = 0; i < buysFromSession.get(session).size(); i++) {
            String product = buysFromSession.get(session).get(i).getProductId();
            for(String customer: sessionsFromCustomer.keySet()) {
               int numViews = 0;
               List<String> customerSessions = sessionsFromCustomer.get(customer);
               for(String session2 : customerSessions) {
                   List<View>views = viewsFromSession.get(session2);
                   for(int j = 0; j < views.size(); j++) {
                       if(views.get(j).getProduct().equals(product)) {
                           numViews++;
                           break;
                       }
                   }
               }
               System.out.println(customer);
               System.out.println(" " + product + "" + numViews);
            }
         }
      }
   }

      //write this after you have figured out how to store your data
      //make sure that you understand the problem
   private static void printStatistics(final Map<String, List<String>> sessionsFromCustomer,
                                       final Map<String, List<View>> viewsFromSession,
                                       final Map<String, List<Buy>> buysFromSession)
   {
      printSessionPriceDifference( sessionsFromCustomer, viewsFromSession, buysFromSession);
      printCustomerItemViewsForPurchase( sessionsFromCustomer, viewsFromSession, buysFromSession);

      /*This is commented out as it will not work until you read
         in your data to appropriate data structures, but is included
         to help guide your work - it is an example of printing the
         data once propogated */
         printOutExample(sessionsFromCustomer, viewsFromSession, buysFromSession);

   }

   /* provided as an example of a method that might traverse your
      collections of data once they are written 
      commented out as the classes do not exist yet - write them! */

   private static void printOutExample(
      final Map<String, List<String>> sessionsFromCustomer,
      final Map<String, List<View>> viewsFromSession,
      final Map<String, List<Buy>> buysFromSession)
   {
      //for each customer, get their sessions
      //for each session compute views
      for(Map.Entry<String, List<String>> entry:
         sessionsFromCustomer.entrySet())
      {
         System.out.println(entry.getKey());
         List<String> sessions = entry.getValue();
         for(String sessionID : sessions)
         {
            System.out.println("\tin " + sessionID);
            List<View> theViews = viewsFromSession.get(sessionID);
            for (View thisView: theViews)
            {
               System.out.println("\t\tviewed " + thisView.getProduct());
            }
         }
      }
   }


      //called in populateDataStructures
   private static void processFile(
      final Scanner input,
      final Map<String, List<String>> sessionsFromCustomer,
      final Map<String, List<Buy>> sessionsFromBuy,
      final Map<String, List<View>> sessionsFromView)
   {
      while (input.hasNextLine())
      {
         processLine(input.nextLine(), sessionsFromCustomer, sessionsFromBuy, sessionsFromView);
      }
   }

      //called from main - mostly just pass through important data structures
   private static void populateDataStructures(
      final String filename,
      final Map<String, List<String>> sessionsFromCustomer, final Map<String, List<Buy>> sessionsFromBuy,
      final Map<String, List<View>> sessionsFromView)
      throws FileNotFoundException
   {
      try (Scanner input = new Scanner(new File(filename)))
      {
         processFile(input, sessionsFromCustomer, sessionsFromBuy, sessionsFromView);
      }
   }

   private static String getFilename(String[] args)
   {
      if (args.length < 1)
      {
         System.err.println("Log file not specified.");
         System.exit(1);
      }

      return args[0];
   }

   public static void main(String[] args)
   {
      /* Map from a customer id to a list of session ids associated with
       * that customer.
       */
      final Map<String, List<String>> sessionsFromCustomer = new HashMap<>();

      /* create additional data structures to hold relevant information */
      /* they will most likely be maps to important data in the logs */
      final Map<String, List<Buy>> sessionsFromProductBuy = new HashMap<>();
      final Map<String, List<View>> sessionsFromProductView = new HashMap<>();

      final String filename = getFilename(args);

      try
      {
         populateDataStructures(filename, sessionsFromCustomer, sessionsFromProductBuy, sessionsFromProductView);
         printStatistics(sessionsFromCustomer, sessionsFromProductView, sessionsFromProductBuy);
      }
      catch (FileNotFoundException e)
      {
         System.err.println(e.getMessage());
      }
   }
}
