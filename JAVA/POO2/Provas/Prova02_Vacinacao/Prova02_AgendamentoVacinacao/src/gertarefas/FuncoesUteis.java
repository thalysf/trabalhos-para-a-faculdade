package gertarefas;


import dominio.Vacina;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jean_
 */
public class FuncoesUteis {
    
    // Converte e valida uma DATA
    public static Date strToDate(String txtData) throws ParseException {
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);
        return formato.parse(txtData);

    }

    // Converte e valida uma DATA
    public static String dateToStr(Date data) throws ParseException {
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);
        return formato.format(data);

    }
    
    // Converte e valida uma DATA para inserir no BANCO
    public static String dateToStrBanco(Date data) throws ParseException {
        DateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
        formato.setLenient(false);
        return formato.format(data);

    }
    

    public static boolean isCPF(String parCpf) {
        
        // considera-se erro cpf's formados por uma sequencia de numeros iguais
        String cpf;
        cpf = parCpf.replace(".", "");
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        
        if (cpf.equals("00000000000")
                || cpf.equals("11111111111")
                || cpf.equals("22222222222") || cpf.equals("33333333333")
                || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777")
                || cpf.equals("88888888888") || cpf.equals("99999999999")
                || (cpf.length() != 11)) {
            return false;
            
            // SOMENTE TESTE
            //return true;
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        // Calculo do 1o. Digito Verificador
        sm = 0;
        peso = 10;
        for (i = 0; i < 9; i++) {
            // converte o i-esimo caractere do cpf em um numero:
            // por exemplo, transforma o caractere '0' no inteiro 0         
            // (48 eh a posicao de '0' na tabela ASCII)         
            num = (int) (cpf.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11)) {
            dig10 = '0';
        } else {
            dig10 = (char) (r + 48); // converte no respectivo caractere numerico
        }
        // Calculo do 2o. Digito Verificador
        sm = 0;
        peso = 11;
        for (i = 0; i < 10; i++) {
            num = (int) (cpf.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11)) {
            dig11 = '0';
        } else {
            dig11 = (char) (r + 48);
        }

        // Verifica se os digitos calculados conferem com os digitos informados.
        if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
            return (true);
        } else {
            return (false);
        }
        
        
    }
    public static boolean isValidDate(String strDate) {
        String dateFormat = "dd/MM/uuuu";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern(dateFormat)
                .withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate date = LocalDate.parse(strDate, dateTimeFormatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    public static java.sql.Date utilDateToSqlDate(java.util.Date utilDate)
    {
        java.sql.Date dataSql = new java.sql.Date(utilDate.getTime());
        return dataSql;
    }
    
    public static boolean validarCamposInsercao(Long id, String cpf, String nome, String dataDose01, String dataDose02, Vacina vacinaSelecionada, int tipoVerificacao, JFrame frame) {
        // tipoVerificacao 1 -> verifica campos relacionados a inserção da covid 1ª dose
        //                 2 - > verifica campos relacionados a inserção de outras
        String erros = "";
        if (tipoVerificacao == 2)
        {
            if(id == null)
            {
                erros += "Para alterar um registro o ID não pode estar vazio!";
            }
            if(dataDose02.isEmpty())
            {
                erros += "A data da segunda dose não pode estar vazia!";
            }
            if(!FuncoesUteis.isValidDate(dataDose02))
            {
                erros += "Informe uma data válida!";
            }
        }
        if (tipoVerificacao == 3) {
            dataDose02 = "11/11/2011"; // Quando é selecionado o grupo de vacina Outras
            // não há necessidade de verificar data da dose 2, pois a mesma não existe
            // por isso crio uma data "fake" para ignorar essa verificação
        }
        if(tipoVerificacao != 2)
        {
        if (cpf.isEmpty() || nome.isEmpty() || dataDose01.isEmpty() || dataDose02.isEmpty() || vacinaSelecionada == null) {
            erros += "Um ou mais campos vazios!\n";
        }
        if (!FuncoesUteis.isCPF(cpf)) {
            erros += "Informe um CPF válido!\n";
        }
        if (!FuncoesUteis.isValidDate(dataDose01) || !FuncoesUteis.isValidDate(dataDose02)) {
            erros += "Uma ou mais datas estão incorretas!\n";
        }
        }
        if (!erros.isEmpty()) {
            JOptionPane.showMessageDialog(frame, erros);
            return false;
        }
        return true;
    }
}
