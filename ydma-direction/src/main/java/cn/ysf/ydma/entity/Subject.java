package cn.ysf.ydma.entity;

public class Subject {

    private Integer id;

    private String name;

    private Direction direction;
    private Integer directionId;



    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subject.id
     *
     * @param id the value for subject.id
     *
     * @mbg.generated Wed Apr 29 18:56:24 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column subject.name
     *
     * @return the value of subject.name
     *
     * @mbg.generated Wed Apr 29 18:56:24 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subject.name
     *
     * @param name the value for subject.name
     *
     * @mbg.generated Wed Apr 29 18:56:24 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column subject.direction_id
     *
     * @return the value of subject.direction_id
     *
     * @mbg.generated Wed Apr 29 18:56:24 CST 2020
     */
    public Integer getDirectionId() {
        return directionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subject.direction_id
     *
     * @param directionId the value for subject.direction_id
     *
     * @mbg.generated Wed Apr 29 18:56:24 CST 2020
     */
    public void setDirectionId(Integer directionId) {
        this.directionId = directionId;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", direction=" + direction +
                ", directionId=" + directionId +
                '}';
    }
}