package Ex2;


public class CakeMaster {
    private CakeBuilder cakeBuilder;

    public void setCakeBuilder(CakeBuilder cakeBuilder) {
        this.cakeBuilder = cakeBuilder;
    }

    public void createCake(String m) {

        this.cakeBuilder.addCakeLayer();
        this.cakeBuilder.addTopping();
        this.cakeBuilder.addMessage(m);
        this.cakeBuilder.createCake();
    }

    public void createCake(int nlayers, String msg) {
        for (int i = 0; i < nlayers; i++) {
            this.cakeBuilder.addCakeLayer();
        }
        if (nlayers == 2) {
            this.cakeBuilder.addCreamLayer();
        }
        else if (nlayers == 3) {
            this.cakeBuilder.addTopLayer();
        }
        this.cakeBuilder.addTopping();
        this.cakeBuilder.addMessage(msg);
        this.cakeBuilder.createCake();
    }

    public void createCake(Shape m, int nlayers, String msg) {
        this.cakeBuilder.setCakeShape(m);
        for (int i = 0; i < nlayers; i++) {
            this.cakeBuilder.addCakeLayer();
        }
        if (nlayers == 2) {
            this.cakeBuilder.addCreamLayer();
        }
        else if (nlayers == 3) {
            this.cakeBuilder.addTopLayer();
        }
        this.cakeBuilder.addCreamLayer();
        this.cakeBuilder.addTopLayer();
        this.cakeBuilder.addTopping();
        this.cakeBuilder.addMessage(msg);
        this.cakeBuilder.createCake();
    }

    public Cake getCake() {
        return this.cakeBuilder.getCake();
    }
}
