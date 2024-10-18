public class Specialization {
    // Attributes
    private String type; // ex:, swimming, judo
    private Lesson lesson; // Relates to a Lesson

    // Constructor
    public Specialization(String type, Lesson lesson) {
        this.type = type;
        this.lesson = lesson;
    }

    // Methods
    public String getType() {
        return type;
    }

    public Lesson getLesson() {
        return lesson;
    }
}
