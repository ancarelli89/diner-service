package it.reply.microservices.diner.domain.model.entity;


public class Diner extends BaseEntity<String> {

    private String surname;
  	private String nickname;
  	private String address; 


    public Diner(String name, String id,String surname, String nickname, String address) {
        super(id, name);
        this.address = address;
        this.surname = surname;
        this.nickname = nickname;
    }
    
    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    
    public String getSurname() {
  		return surname;
  	}


  	public void setSurname(String surname) {
  		this.surname = surname;
  	}


  	public String getNickname() {
  		return nickname;
  	}


  	public void setNickname(String nickname) {
  		this.nickname = nickname;
  	}

	@Override
	public String toString() {
		return "Diner [surname=" + surname + ", nickname=" + nickname + ", address=" + address + "]";
	}




  


}
