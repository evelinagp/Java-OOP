package InterfacesAndAbstractionsBirthdayCelebrationsEx03;

//-	id: String
//-	model: String
public class Robot implements Identifiable, Machine {
    private String model;
    private String id;

    public Robot(String id, String model) {
        this.setModel(model);
        this.setId(id);
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setId(String id) {
        this.id = id;
    }


    public String getModel() {
        return model;
    }

    @Override
    public String getId() {
        return id;
    }

    //+	Robot(Stirng, String)
//+	getId(): String
//+	getModel(): String
}
