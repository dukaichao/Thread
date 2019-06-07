package dkc.dkc_listen_zx_cp;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-06-06
 * Time:19:08
 */
public class Goods {
    private String name;
    private Double prices;

    public Goods(String name, Double prices) {
        this.name = name;
        this.prices = prices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", prices=" + prices +
                '}';
    }
}
