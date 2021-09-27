package homework_4.custom_annotation;


@GuitarDefault
public class Guitar {
    private String model;
    private String manufacturer;
    private Integer yearOfManufacture;
    private Integer serialNumber;

    public Guitar() {
        GuitarDefault gD = this.getClass().getAnnotation(GuitarDefault.class);
        this.model = gD.model();
        this.manufacturer = gD.manufacturer();
        this.yearOfManufacture = gD.yearOfManufacture();
        this.serialNumber = gD.serialNumber();

    }

    public Guitar(String model, String manufacturer, Integer yearOfManufacture, Integer serialNumber) {
        GuitarDefault gD = this.getClass().getAnnotation(GuitarDefault.class);
        if (model == null || model.isEmpty()) {
            this.model = gD.model();
        } else {
            this.model = model;
        }

        if (manufacturer == null || manufacturer.isEmpty()) {
            this.manufacturer = gD.manufacturer();
        } else {
            this.manufacturer = manufacturer;
        }

        if (yearOfManufacture == null || yearOfManufacture <= 1200) {
            this.yearOfManufacture = gD.yearOfManufacture();
        } else {
            this.yearOfManufacture = yearOfManufacture;
        }

        if (serialNumber == null || serialNumber < 0) {
            this.serialNumber = gD.serialNumber();
        } else {
            this.serialNumber = serialNumber;
        }

    }

    public String toString() {
        String s = "Model of guitar: " + model + "; Manufacturer: " + manufacturer + "; year: " + yearOfManufacture + "; S/N: " + serialNumber;
        return s;
    }

}
