package GetCourses_OAuth_UsingPOJO_Project.AllPOJOS;

public class POJO_CourseDetails_Test {
    private String url;
    private String services;
    private String expertise;
    private POJO_CoursesTest courses;
    private String instructor;
    private String linkedIn;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public POJO_CoursesTest getCourses() {
        return courses;
    }

    public void setCourses(POJO_CoursesTest courses) {
        this.courses = courses;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }


}
