import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PessoaTest {

    // --- REQUISITO 1: Nome e Sobrenome separados por espaço ---
    @Test
    public void test1_1_NomeValidoComSobrenome() {
        assertDoesNotThrow(() -> {
            Pessoa p = new Pessoa("Carlos Silva", 30);
            assertEquals("Carlos Silva", p.getNome());
        });
    }

    @Test
    public void test1_2_NomeSemSobrenomeDeveLancarExcecao() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Pessoa("Carlos", 30);
        });
        assertEquals("Deve ser informado o sobrenome", exception.getMessage());
    }

    // --- REQUISITO 2: Nome e sobrenome com mais de 5 caracteres ---
    @Test
    public void test2_1_NomeComTamanhoValido() {
        assertDoesNotThrow(() -> {
            Pessoa p = new Pessoa("Ana Costa", 25);
            assertEquals("Ana Costa", p.getNome());
        });
    }

    @Test
    public void test2_2_NomeMuitoCurtoDeveLancarExcecao() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Pessoa("An Co", 25);
        });
        assertEquals("Nome e sobrenome devem possuir mais do que 5 caracteres", exception.getMessage());
    }

    // --- REQUISITO 3: Apenas letras do alfabeto ---
    @Test
    public void test3_1_NomeApenasComLetras() {
        assertDoesNotThrow(() -> {
            Pessoa p = new Pessoa("Pedro Souza", 40);
            assertEquals("Pedro Souza", p.getNome());
        });
    }

    @Test
    public void test3_2_NomeComCaracterInvalidoDeveLancarExcecao() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Pessoa("Maria123 Silva", 40);
        });
        assertEquals("Caracter inválido encontrado!", exception.getMessage());
    }

    // --- REQUISITO 4: Validação de Idade (Valores Limites) ---
    @Test
    public void test4_1_IdadeNegativaDeveLancarExcecao() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Pessoa("Lucas Lima", -1);
        });
        assertEquals("Idade não pode ser negativa", exception.getMessage());
    }

    @Test
    public void test4_2_IdadeMaiorQue100DeveLancarExcecao() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Pessoa("Lucas Lima", 101);
        });
        assertEquals("Idade não pode ser maior que 100", exception.getMessage());
    }

    @Test
    public void test4_3_IdadeNoLimiteMinimo() {
        assertDoesNotThrow(() -> {
            Pessoa p = new Pessoa("Lucas Lima", 0);
            assertEquals(0, p.getIdade());
        });
    }

    @Test
    public void test4_4_IdadeNoLimiteMaximo() {
        assertDoesNotThrow(() -> {
            Pessoa p = new Pessoa("Lucas Lima", 100);
            assertEquals(100, p.getIdade());
        });
    }
    }
          
