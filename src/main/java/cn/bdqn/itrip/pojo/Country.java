package cn.bdqn.itrip.pojo;

public class Country {
    private Integer id;
    private  String countryName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Country(Integer id, String countryName) {
        this.id = id;
        this.countryName = countryName;
    }

    public Country() {
        super();
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
