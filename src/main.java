public class main
{
    public static void main (String[] args)
    {
        try {
            Conjunto<String> a = new Conjunto<String>(10);
            System.out.println(a);
            a.inclua("C");
            System.out.println(a);
            a.inclua("C++");
            System.out.println(a);
            a.inclua("Java");
            System.out.println("incluiu");
            System.out.println(a);
            a.remova("Java");
            System.out.println("removeu");
            System.out.println(a);
            a.remova("Fortran");
            System.out.println("removeu item ausente");
            System.out.println(a);


            /*Conjunto<Data> b = new Conjunto<Data>(6);
            b.inclua(new Data((byte) 19, (byte) 1, (short) 1966));
            b.inclua(new Data((byte) 29, (byte) 8, (short) 2022));



            Conjunto<Conjunto<String>> c = new Conjunto<Conjunto<String>>();
            c.inclua(a);

            Conjunto<Object> d = new Conjunto<Object>();
            d.inclua("Javascript");
            d.inclua(new Data((byte) 19, (byte) 1, (short) 1966));
            d.inclua(13);
            d.inclua(a); */
        } catch (Exception erro) {
            System.err.println(erro.getMessage());;
        }
    }
}