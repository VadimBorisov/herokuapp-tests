import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

  @BeforeAll
  public static void beforeAll() {
    Configuration.baseUrl = "https://the-internet.herokuapp.com/";
//    Configuration.holdBrowserOpen = true;
  }

  @Test
  void successfulDragAndDrop() {
    open("drag_and_drop");

    Selenide.actions()
            .clickAndHold($("#column-a"))
            .moveToElement($("#column-b"))
            .release()
            .build()
            .perform();

    $("#column-a header").shouldHave(text("B"));
  }

}
