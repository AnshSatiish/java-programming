
public class Driver
{
    public static void main(String[] args) 
    {
        Singers singer1 = new Singers();

        //Displaying default values
        System.out.println("DEFAULT SINGER VALUES");
        System.out.println();

        System.out.println("Singer ID: " + singer1.getsingerId());
        System.out.println("Singer Name: " + singer1.getSingerName());
        System.out.println("Singer Address: " + singer1.getSingerAddress());
        System.out.println("Date of Birth: " + singer1.getDateOfBirth());
        System.out.println("Number of Albums Published: " + singer1.getNoOfAlbums());
        System.out.println();

        //Setting values for singer1
        singer1.setAll(3, "Sabrina Carpenter", "932 Beverly Hills", "11/05/1999", 6);

        System.out.println("AFTER SETTING");
        System.out.println();
        System.out.println();
        System.out.println("Singer ID: " + singer1.getsingerId());
        System.out.println("Singer Name: " + singer1.getSingerName());
        System.out.println("Singer Address: " + singer1.getSingerAddress());
        System.out.println("Date of Birth: " + singer1.getDateOfBirth());
        System.out.println("Number of Albums Published: " + singer1.getNoOfAlbums());
        System.out.println();

        
    }
}