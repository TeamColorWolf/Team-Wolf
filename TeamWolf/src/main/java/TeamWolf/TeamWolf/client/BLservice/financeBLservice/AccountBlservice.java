package TeamWolf.TeamWolf.client.BLservice.financeBLservice;

public interface AccountBlservice {
    public int add(String name);
    public int delete(String name);
    public int update(String previousname,String newname);
    public int find(String name);
 
}
