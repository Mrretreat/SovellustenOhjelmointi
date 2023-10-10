public class Elain {
    protected String mNimi;

    public Elain(){
        mNimi = "nimetön";
    }

    public Elain (String aNimi){
        mNimi = aNimi;
    }

    public void heraa(){
        System.out.println(mNimi+ " herää.");
    }

        public void lepaa(){
        System.out.println(mNimi+ " lepää.");
    }

        public void toimi(){
        System.out.println(mNimi+ " toimii.");
    }
}
