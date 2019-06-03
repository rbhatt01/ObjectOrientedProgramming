import java.util.List;
import java.util.Objects;

class Student
{
   private final String surname;
   private final String givenName;
   private final int age;
   private final List<CourseSection> currentCourses;

   public Student(final String surname, final String givenName, final int age,
      final List<CourseSection> currentCourses)
   {
      this.surname = surname;
      this.givenName = givenName;
      this.age = age;
      this.currentCourses = currentCourses;
   }

   public boolean equals(Object obj){
      if(obj != null) {
         if(obj.getClass() == Student.class){
            return Objects.equals(((Student)obj).age, age) &&
                    Objects.equals(((Student)obj).surname, surname) &&
                    Objects.equals(((Student)obj).givenName, givenName) &&
                    Objects.equals(((Student)obj).currentCourses, currentCourses);

         }
      }
      return false;
   }


   public int hashCode(){
      return Objects.hash(surname, givenName, age, currentCourses);
   }
}
