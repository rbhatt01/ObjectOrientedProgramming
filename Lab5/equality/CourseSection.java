import java.time.LocalTime;

class CourseSection
{
   private final String prefix;
   private final String number;
   private final int enrollment;
   private final LocalTime startTime;
   private final LocalTime endTime;

   public CourseSection(final String prefix, final String number,
      final int enrollment, final LocalTime startTime, final LocalTime endTime)
   {
      this.prefix = prefix;
      this.number = number;
      this.enrollment = enrollment;
      this.startTime = startTime;
      this.endTime = endTime;
   }

   public boolean equals(Object obj) {
      if(obj != null) {
         if(obj.getClass().equals(CourseSection.class)) {
            if (((((CourseSection)obj).prefix == null && prefix == null ||((CourseSection) obj).prefix.equals(prefix)))&&
                    (((CourseSection)obj).number == null && number == null || ((CourseSection) obj).number.equals(number))
                    && ((CourseSection) obj).enrollment == enrollment &&
                    (((CourseSection)obj).startTime == null && startTime == null ||((CourseSection) obj).startTime.equals(startTime))
                    && (((CourseSection) obj).endTime == null && endTime == null || ((CourseSection) obj).endTime.equals(endTime))) {
               return true;
            }
         }
      }
      return false;
   }

   public int hashCode(){
      if(this != null) {
         int result = 1;
         result *= enrollment;
         result += prefix.hashCode();
         result += number.hashCode();
         return result;
      }
    return enrollment;
   }
   // additional likely methods not defined since they are not needed for testing
}
