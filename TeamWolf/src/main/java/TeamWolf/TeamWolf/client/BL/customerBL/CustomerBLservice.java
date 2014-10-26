package TeamWolf.TeamWolf.client.BL.customerBL;

public interface CustomerBLservice {
      public String getNumber();
      public String getType();
      public String getLevel();
      public String getTel();
      public String getAddress();
      public String getPostnumber();
      public String getEmail();
      public double getShouldpay();
      public double getCouldCollect();
      public double getShouldCollect();
      public String getDefaultUser();     
      public int setNumber(String number);
      public int setType(String type);
      public int setLevel(String level);
      public int setTel(String tel);
      public int setAddress(String address);
      public int setPostnumber(String postnumber);
      public int setEmail(String email);
      public int setShouldpay(double shouldpayUPANDDOWN);
      public int setCouldCollect(double couldpayUPANDDOWN);
      public int setShouldCollect(double shouldcollectUPANDDOWN);
      public int setDefaultUser(String defaultUser);   
      
}
