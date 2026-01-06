import br.com.alura.conversordemoeda.Principal.Principal;

import java.io.IOException;

public class Main {

    private Object getMoedaAConverter;

    public void main(String[] args) throws IOException, InterruptedException {
        Principal principal = new Principal();
        principal.exibeMenu();
    }
}

