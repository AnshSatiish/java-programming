

public class Singers
{
    public int singerID;
    public String singerName;
    public String singerAddress;
    public String singerDOB;
    public int noOfAlbums;

  //Constructor 1: Default Constructor
    public Singers()
    {
        this.singerID = 0;
        this.singerName = "Unknown";
        this.singerAddress = "123 Random St";
        this.singerDOB = "01/01/2000";
        this.noOfAlbums = 0;
    }

    //Constructor 2: 1 argument 
    public Singers(int singerId)
    {
        this.singerID = singerId;
    }

    
    //Constructor 3:  2 arguments
    public Singers(int singerId, String singerName)
    {
        this.singerID = singerId;
        this.singerName = singerName;
    }

    //Constructor 4:  3 arguments
    public Singers(int singerId, String singerName, String singerAddress)
    {
        this.singerID = singerId;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
    }

    //Constructor 5:  4 arguments
    public Singers(int singerId, String singerName, String singerAddress, String singerDOB)
    {
        this.singerID = singerId;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
        this.singerDOB = singerDOB;
    }

     //Constructor 6:  all arguments
     public Singers(int singerId, String singerName, String singerAddress, String singerDOB, int noOfAlbums)
     {
         this.singerID = singerId;
         this.singerName = singerName;
         this.singerAddress = singerAddress;
         this.singerDOB = singerDOB;
         this.noOfAlbums = noOfAlbums;
     }
 
    //Getters
public int getsingerId() 
{
    return singerID;
}

public String getSingerName() {
    return singerName;
}

public String getSingerAddress() {
    return singerAddress;
}

public String getDateOfBirth() {
    return singerDOB;
}

public int getNoOfAlbums() {
    return noOfAlbums;
}


//Setters
public void setId(int singerID) {
    this.singerID = singerID;
}

public void setName(String singerName) {
    this.singerName = singerName;
}

public void setAddress(String singerAddress) {
    this.singerAddress = singerAddress;
}

public void setDateOfBirth(String singerDOB) {
    this.singerDOB = singerDOB;
}

public void setAlbumsPublished(int noOfAlbums) {
    this.noOfAlbums = noOfAlbums;
}

public void setAll(int singerID, String singerName, String singerAddress, String singerDOB, int noOfAlbums) {
    this.singerID = singerID;
    this.singerName = singerName;
    this.singerAddress = singerAddress;
    this.singerDOB = singerDOB;
    this.noOfAlbums = noOfAlbums;
}
}