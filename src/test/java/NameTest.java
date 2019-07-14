import domain.Name;
import domain.message.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {
    @Test
    @DisplayName("[success] 알파벳 대문자 3자리로 이루어진 값이 입력되면 정상적으로 이름이 생성된다.")
    void createNameSuccessTest() {
        //Given
        String nameStr = "JEJ";
        Name name = Name.from(nameStr);
        
        //When
        Boolean equalsName = name.isEqualsName(nameStr);
        
        //Then
        Assertions.assertThat(equalsName).isTrue();
    }
    
    @Test
    @DisplayName("[fail] null 이 입력되면 Exception 발생")
    void createNameNullTest() {
        //Given
        String nameStr = null;
        
        //When
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> Name.from(nameStr))
          .withMessage(ErrorMessage.EMPTY_VALUE.getMessage());
    }
    
    @Test
    @DisplayName("[fail] null 이 입력되면 Exception 발생")
    void createNameEmptyValueTest() {
        //Given
        String nameStr = "";
        
        //When
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> Name.from(nameStr))
          .withMessage(ErrorMessage.EMPTY_VALUE.getMessage());
    }
    
    @Test
    @DisplayName("[fail] 알파벳 3글자 이외의 값이 들어오면 Exception 발생")
    void createNameWrongValueTest() {
        //Given
        String nameStr = "   ";
        
        //When
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> Name.from(nameStr))
          .withMessage(ErrorMessage.EMPTY_VALUE.getMessage());
    }
}
