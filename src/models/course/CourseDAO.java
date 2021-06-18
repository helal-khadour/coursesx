package models.course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.*;


public class CourseDAO {
    protected ArrayList<CourseModel> data;

    public CourseDAO() {
        this.data = new ArrayList<>();
    }

    public ArrayList<CourseModel> getData() {
        return this.data;
    }

    public boolean retrieveAllCourses() {
        this.data.clear();
        String query = "select * from courses";
        ResultSet result = BasicDB.retrieve(query);

        try {
            if (!result.next())
                return false;
            do {
                CourseModel temp = new CourseModel();
                temp.setId(result.getInt(1));
                temp.setTitle(result.getString(2));
                temp.setDescription(result.getString(3));
                temp.setBanner(result.getString(4));
                temp.setCreatedAt(result.getDate(5));
                temp.setRequirements(result.getString(6));
                temp.setTagId(result.getInt(7));
                temp.setInstructorUserId(result.getInt(8));
                this.data.add(temp);
            } while (result.next());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean retrieveCourse(int id) {
        this.data.clear();
        String query = "select * from courses where id = '" + id + "'";
        ResultSet result = BasicDB.retrieve(query);

        try {
            if (!result.next())
                return false;
            CourseModel temp = new CourseModel();
            temp.setId(result.getInt(1));
            temp.setTitle(result.getString(2));
            temp.setDescription(result.getString(3));
            temp.setBanner(result.getString(4));
            temp.setCreatedAt(result.getDate(5));
            temp.setRequirements(result.getString(6));
            temp.setTagId(result.getInt(7));
            temp.setInstructorUserId(result.getInt(8));
            this.data.add(temp);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void add(CourseModel course) {
        this.data.clear();
        String query = "insert into courses (title, description, banner, requirements, tag_id, instructor_user_id) values( '" +
                course.getTitle() + "','" + course.getDescription() + "','"
                + course.getBanner() + "','" + course.getRequirements() + "',"
                + course.getTagId() + "," + course.getInstructorUserId() + ")";
        int rows = BasicDB.manipulate(query);
        this.data.add(course);
    }

    //    public void update(String name, int newCopies) {
    //        //Form the query
    //        String query = "update books set copies = " + newCopies + " where name= '" + name + "'";
    //        //Execute the query
    //        int rows = BasicDB.manipulate(query);
    //    }

    public void delete(int id) {
        String query = "delete from courses where id= '" + id + "'";
        int rows = BasicDB.manipulate(query);
    }


}
