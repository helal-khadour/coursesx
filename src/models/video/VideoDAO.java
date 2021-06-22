package models.video;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.*;


public class VideoDAO {
    protected ArrayList<VideoModel> data;

    public VideoDAO() {
        this.data = new ArrayList<>();
    }

    public ArrayList<VideoModel> getData() {
        return this.data;
    }

    public boolean retrieveAllCourseVideos(int courseId) {
        this.data.clear();
        String query = "select * from videos where course_id = " + courseId;
        ResultSet result = BasicDB.retrieve(query);

        try {
            if (!result.next())
                return false;
            do {
                VideoModel temp = new VideoModel();
                temp.setId(result.getInt(1));
                temp.setName(result.getString(2));
                temp.setUrl(result.getString(3));
                temp.setCourseId(result.getInt(4));
                this.data.add(temp);
            } while (result.next());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean retrieveVideo(int id) {
        this.data.clear();
        String query = "select * from videos where id = '" + id + "'";
        ResultSet result = BasicDB.retrieve(query);

        try {
            if (!result.next())
                return false;
            VideoModel temp = new VideoModel();
            temp.setId(result.getInt(1));
            temp.setName(result.getString(2));
            temp.setUrl(result.getString(3));
            temp.setCourseId(result.getInt(4));
            this.data.add(temp);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void add(VideoModel video) {
        this.data.clear();
        String query = "insert into videos (name, url, course_id) values( '" +
                video.getName() + "','" + video.getUrl().replace("\\", "\\\\") + "',"
                + video.getCourseId() + ")";

        int rows = BasicDB.manipulate(query);
        this.data.add(video);
    }

    //    public void update(String name, int newCopies) {
    //        //Form the query
    //        String query = "update books set copies = " + newCopies + " where name= '" + name + "'";
    //        //Execute the query
    //        int rows = BasicDB.manipulate(query);
    //    }

    public void delete(int id) {
        String query = "delete from videos where id= '" + id + "'";
        int rows = BasicDB.manipulate(query);
    }

    public void deleteCourseVideos(int courseId) {
        String query = "delete from videos where course_id= '" + courseId + "'";
        int rows = BasicDB.manipulate(query);
    }


}
