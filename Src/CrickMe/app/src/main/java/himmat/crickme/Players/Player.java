package himmat.crickme.Players;

/**
 * Created by Himmat on 21-11-2017.
 */

public class Player {
    public int Id;
    public String NickName;
    public String FirstName;
    public String LastName;
    public String FullName;
    public String Description;
    public String Role;
    public String Position;
    public String IsActive;

    public Player(int id, String nickName, String firstName, String lastName, String fullName, String description, String role, String position, String isActive) {
        Id = id;
        NickName = nickName;
        FirstName = firstName;
        LastName = lastName;
        FullName = fullName;
        Description = description;
        Role = role;
        Position = position;
        IsActive = isActive;
    }
}
