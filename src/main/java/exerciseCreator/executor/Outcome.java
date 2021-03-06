package exerciseCreator.executor;

public class Outcome {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String titleDesc;
    private String exerciseDesc;
    private String grade;
    private int points;
    private int maxPoints;
    private String errorDesc = "";

    public Outcome(){
    }

    public Outcome(String grade, String firstName, String lastName, String phoneNumber, String email, String exerciseDesc, String titleDesc, int points, int maxPoints, String errorDesc){
        this.grade = grade;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.exerciseDesc = exerciseDesc;
        this.titleDesc = titleDesc;
        this.points = points;
        this.maxPoints = maxPoints;
        this.errorDesc = errorDesc;
    }

    public Outcome(Outcome outcome) {
        this.grade = outcome.grade;
        this.firstName = outcome.firstName;
        this.lastName = outcome.lastName;
        this.phoneNumber = outcome.phoneNumber;
        this.email = outcome.email;
        this.exerciseDesc = outcome.exerciseDesc;
        this.titleDesc = outcome.titleDesc;
        this.points = outcome.points;
        this.maxPoints = outcome.maxPoints;
        this.errorDesc = outcome.errorDesc;
    }

    public String getGrade() {
        return grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getExerciseDesc() {
        return exerciseDesc;
    }

    public String getTitleDesc() {
        return titleDesc;
    }

    public int getPoints() {
        return points;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTitleDesc(String titleDesc) {
        this.titleDesc = titleDesc;
    }

    public void setExerciseDesc(String exerciseDesc) {
        this.exerciseDesc = exerciseDesc;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("First Name: ");
        builder.append(firstName);
        builder.append(", ");
        builder.append("Last Name: ");
        builder.append(lastName);
        builder.append(", ");
        builder.append("E-mail: ");
        builder.append(email);
        builder.append(", ");
        builder.append("Phone: ");
        builder.append(phoneNumber);
        builder.append(", ");
        builder.append("Exercise title: ");
        builder.append(titleDesc);
        builder.append(", ");
        builder.append("Exercise description: ");
        builder.append(exerciseDesc);
        builder.append(", ");
        builder.append("Grade: ");
        builder.append(grade);
        builder.append(", ");
        builder.append("Points: ");
        builder.append(points);
        builder.append(", ");
        builder.append("Max points: ");
        builder.append(maxPoints);
        builder.append(", ");
        builder.append("Error description: ");
        builder.append(errorDesc);
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Outcome outcome = (Outcome) o;

        if (points != outcome.points) return false;
        if (maxPoints != outcome.maxPoints) return false;
        if (firstName != null ? !firstName.equals(outcome.firstName) : outcome.firstName != null) return false;
        if (lastName != null ? !lastName.equals(outcome.lastName) : outcome.lastName != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(outcome.phoneNumber) : outcome.phoneNumber != null) return false;
        if (email != null ? !email.equals(outcome.email) : outcome.email != null) return false;
        if (titleDesc != null ? !titleDesc.equals(outcome.titleDesc) : outcome.titleDesc != null) return false;
        if (exerciseDesc != null ? !exerciseDesc.equals(outcome.exerciseDesc) : outcome.exerciseDesc != null)
            return false;
        if (grade != null ? !grade.equals(outcome.grade) : outcome.grade != null) return false;
        return errorDesc != null ? errorDesc.equals(outcome.errorDesc) : outcome.errorDesc == null;
    }
}
