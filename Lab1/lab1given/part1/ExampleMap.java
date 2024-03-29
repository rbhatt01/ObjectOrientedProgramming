import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class ExampleMap
{
   public static List<String> highEnrollmentStudents(
      Map<String, List<Course>> courseListsByStudentName, int unitThreshold)
   {
      List<String> overEnrolledStudents = new LinkedList<>();

      /*
         Build a list of the names of students currently enrolled
         in a number of units strictly greater than the unitThreshold.
      */
      for (Map.Entry<String, List<Course>> entry : courseListsByStudentName.entrySet()) {
         String studentName = entry.getKey();
         int numUnits = 0;
         for (int i = 0; i < entry.getValue().size(); i++) {
            numUnits += entry.getValue().get(i).getNumUnits();
         }
         if(numUnits > unitThreshold) {
            overEnrolledStudents.add(studentName);
         }
      }
      return overEnrolledStudents;      
   }
}
