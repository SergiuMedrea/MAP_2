import java.util.List;

public class Student {
    private String name;
    private String university;
    List<Pair<String, Integer>> course;

    public Student(String name, String university, List<Pair<String, Integer>> course) {
        this.name = name;
        this.university = university;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", university='" + university + '\'' +
                ", course=" + course +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getUniversity() {
        return university;
    }

    public List<Pair<String, Integer>> getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setCourse(List<Pair<String, Integer>> course) {
        this.course = course;
    }
}
