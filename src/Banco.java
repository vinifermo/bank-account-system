public class Banco {
    //Atributos
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public void estadoAtual() {
        System.out.println("---------------------------------");
        System.out.println("Conta:"+ this.getNumConta());
        System.out.println("Dono:" + this.getDono());
        System.out.println("Saldo:" +this.getSaldo());
        System.out.println("Tipo:"+this.getTipo());
        System.out.println("Status:" +this.getStatus());

    }

    //Métodos Personalizados

    public void abrirConta(String t) {
        this.setTipo(t);
        this.setStatus(true);
        if (t == "CC") {
            this.setSaldo(50);
        } else if (t == "CP") {

            this.setSaldo(150);
        }
        System.out.println("Conta aberta com sucesso!");


    }

    public void fecharConta() {
        if (this.getSaldo()>0); {
            System.out.println("Conta nao pode ser fechada, pois ainda tem dinheiro");
        } if (this.getSaldo()<0) {
            System.out.println("Conta nao pode ser fechada pois tem debito");
        } else {
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }

    }

    public void depositar(float v) {
        if (this.getStatus()) {
            this.saldo = this.saldo + v;
            System.out.println("Deposito realizado na conta de" + this.getDono());
        } else {
            System.out.println("Impossivel depositar em uma conta fechada");

        }

    }

    public void sacar(float v) {
        if (this.getStatus()) {
            if (this.getSaldo() >= v) {
                this.setSaldo(this.getSaldo()- v);
                System.out.println("Saque realizado na conta de" + this.getDono());
            } else {
                System.out.println("Saldo insuficiente para saque");

            }

        } else {
            System.out.println("Impossivel sacar de uma conta fechada!");
        }


    }

    public void pagarMensal() {
        int v = 0;
        if (this.getTipo() == "CC") {
            v=12;

        } else if (this.getTipo() == "CP"){
            v=20;

        }
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo()- v);
            System.out.println("Mensalidade paga com sucesso por"+ this.getDono());
        } else {
            System.out.println("Impossivel pagar uma conta fechada!");
        }

    }

    public void status() {

    }


    public Banco() {
        this.setSaldo(0);
        this.setStatus(false);


    }

    public void setNumConta(int n) {
        this.numConta = n;

    }

    public int getNumConta() {
        return numConta;
    }

    public void setTipo(String t) {
        this.tipo = t;
    }

    public String getTipo() {
        return tipo;
    }

    public void setDono(String d) {
        this.dono = d;
    }

    public String getDono() {
        return dono;
    }

    public void setSaldo(float s) {
        this.saldo = s;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public static void main(String[] args) {
        Banco b1 = new Banco();
        b1.setNumConta(123456-7);
        b1.setDono("Vinicius");
        b1.abrirConta("CC");
        b1.estadoAtual();

        Banco b2 =new Banco();
        b2.setNumConta(123456-8);
        b2.setDono("Maritza");
        b2.abrirConta("CP");
        b2.depositar(100000);
        b2.estadoAtual();

        Banco b3 = new Banco();
        b3.setNumConta(1234569);
        b3.setDono("Pietro");
        b3.abrirConta("CC");
        b3.depositar(100);
        b3.sacar(150);
        b3.fecharConta();
        b3.estadoAtual();



    }
}


