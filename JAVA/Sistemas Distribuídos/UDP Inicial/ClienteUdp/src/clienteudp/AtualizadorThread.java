package clienteudp;

public class AtualizadorThread extends Thread{
    private ClienteForm formulario = null;

    public AtualizadorThread() {
        this.formulario = new ClienteForm();
    }
    
    @Override
    public void run()
    {
        formulario.setVisible(true);
        while(true)
        {
            formulario.atualizaChat();
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
