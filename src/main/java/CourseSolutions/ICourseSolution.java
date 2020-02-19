package CourseSolutions;

import java.io.FileNotFoundException;

public interface ICourseSolution {
    String getProblemDescription();
    short getCourseNumber();
    short getProblemNumber();
    void run() throws FileNotFoundException;
}
