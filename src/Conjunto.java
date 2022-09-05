import java.lang.reflect.Array;

public class Conjunto <X>
{
    private Object[] elem; // private X[] elem;
    private int      qtd=0;
    private int      capacidadeInicial;

    public Conjunto (int capInicial) throws Exception
    {
        if (capInicial<=0)
            throw new Exception ("Capacidade invalida");

        //this.elem = new X      [capInicial];
        this.elem = new Object [capInicial];

        this.capacidadeInicial = capInicial;
    }

    public Conjunto () // construtor padrão (construtor sem parâmetros)
    {
        //this.elem = new X      [10];
        this.elem = new Object [10];

        this.capacidadeInicial = 10;
    }

    private void redimensioneSe (int novaCap)
    {
        //X     [] novo = new X      [novaCap];
        Object[] novo = new Object [novaCap];

        for (int i=0; i<this.qtd; i++)
            novo[i] = this.elem[i];

        this.elem = novo;
    }

    // retorna true, indicando que achou o que era procurado e,
    // junto com o true, a posição onde foi encontrado o que era procurado; ou
    // retorna false, indicando que NÃO achou o que era procurado e,
    // junto com o false, a posição onde é possível incluir aquilo que era procurado
    // e NÃO foi encontrado, caso seja do nosso desejo incluir
    private Object[] ondeEsta (X x)
    {
        for (int i=0; i<this.qtd; i++)
            if (x.equals(this.elem[i]))
            {
                Object[] ret = {true,i};
                return ret;
            }

        Object[] ret = {false,this.qtd};
        return ret;
    }

    public void inclua (X x) throws Exception
    {
        if (x==null)
            throw new Exception ("Elemento ausente");

        if (this.qtd==this.elem.length)
            this.redimensioneSe (2*this.elem.length);

        this.elem[this.qtd] = x;
        this.qtd++;
    }

    public void remova (X x) throws Exception {

        if (x==null)
            throw new Exception ("Elemento ausente");


        Object[] res  = this.ondeEsta(x);
        boolean achou = (Boolean)res[0];
        int posicao   = (Integer)res[1];

        if (!achou)
            throw new Exception("Elemento ausente");

        for (int i = posicao; i < this.qtd - 1; i++)
            this.elem[i] = this.elem[i+1];

        this.qtd--;
        this.elem[this.qtd] = null;

        if ( this.elem.length > this.capacidadeInicial && this.qtd <= ((int)0.25 * this.elem.length))
            this.redimensioneSe((int)0.5 * this.elem.length);

        this.elem[(int) res[1]] = null;
    }


    public int getQtdElementos ()
    {
        return this.qtd;
    }

    public X getElemento (int posicao) throws Exception
    {
        if (posicao<0 || posicao>=this.qtd)
            throw new Exception ("Posicao invalida");

        return (X) this.elem [posicao];
    }

    @Override
    public String toString(){

        if(this.qtd == 0)
            return("Vetor vazio");

        String ret = null;
        ret = "1: " + this.elem[0] + "\n";

        if (this.qtd > 1) {
            for (int i = 1; i < this.qtd; i++) {
                int index = i + 1;
                ret += index + ": " + this.elem[i] + "\n";
            }
        }

        return ret;
    }

}

