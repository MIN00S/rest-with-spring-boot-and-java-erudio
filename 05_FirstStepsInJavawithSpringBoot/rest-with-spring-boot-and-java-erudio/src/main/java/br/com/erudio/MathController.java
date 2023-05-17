package br.com.erudio;


import br.com.erudio.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {
    private static final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)

    public double sum(
            @PathVariable(value = "numberOne")
            String numberOne,
            @PathVariable(value = "numberTwo")
            String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return converToDouble(numberOne) + converToDouble(numberTwo);
    } @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)

    public double subtraction(
            @PathVariable(value = "numberOne")
            String numberOne,
            @PathVariable(value = "numberTwo")
            String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return converToDouble(numberOne) - converToDouble(numberTwo);
    }@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)

    public double multiplication(
            @PathVariable(value = "numberOne")
            String numberOne,
            @PathVariable(value = "numberTwo")
            String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return converToDouble(numberOne) * converToDouble(numberTwo);
    }
@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)

    public double division(
            @PathVariable(value = "numberOne")
            String numberOne,
            @PathVariable(value = "numberTwo")
            String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return converToDouble(numberOne) / converToDouble(numberTwo);
    }
    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)

    public double mean(
            @PathVariable(value = "numberOne")
            String numberOne,
            @PathVariable(value = "numberTwo")
            String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return (converToDouble(numberOne) + converToDouble(numberTwo)) / 2;

        }
        @RequestMapping(value = "/SquareRoot/{number}", method = RequestMethod.GET)

    public double SquareRoot(
            @PathVariable(value = "number")
            String number
            )throws Exception {

        if (!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return Math.sqrt(converToDouble(number));

        }

    private Double converToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        // BR 10,25 US 10.25
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
