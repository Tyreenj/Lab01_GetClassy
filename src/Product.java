import javax.naming.Name;

public class Product {
    private String name;
    private String description;
    private String productID;
    private double cost;

    public String getName() {
        return name;
    }


    public Product(String name, String description, String productID, double cost) {
        this.name = name;
        this.description = description;
        this.productID = productID;
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = (double) cost;
    }
    /**
     * Returns the product's data in CSV format
     * @return the product's data in CSV format
     */
    public String toCSV()
    {
        return name + "," + description + "," + productID + "," + cost;
    }

    /**
     * Returns the product's data in JSON format
     * @return the product's data in JSON format
     */
    public String toJSON()
    {
        String retString = "";
        final char DQ = '\u0022';
        retString = "{" + DQ + "name" + DQ + ":" + DQ + this.name + DQ + ",";
        retString += " " + DQ + "description" + DQ + ":" + DQ + this.description + DQ + ",";
        retString += " " + DQ + "productID" + DQ + ":" + DQ + this.productID + DQ + ",";
        retString += " " + DQ + "cost" + DQ + ":" + DQ + this.cost + DQ + "}";
        return retString;
    }

    /**
     * Returns the product's data in XML format
     * @return the product's data in XML format
     */
    public String toXML()
    {
        String retString = "";
        retString = "<Product>";
        retString += "<name>" + name + "</name>";
        retString += "<description>" + description + "</description>";
        retString += "<productID>" + productID + "</productID>";
        retString += "<cost>" + cost + "</cost>";
        retString += "</Product>";
        return retString;
    }
}
