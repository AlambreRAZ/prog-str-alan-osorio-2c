public class Gato extends  Animal{

    public Gato(String name) {
        super(name); //Inicializa la clase padre, es Animal
    }

    @Override
    public void hacerSonida(){
        System.out.println(name+ "gace Miau");
    }



}
