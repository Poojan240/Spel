package com.example.SpelProject;

import com.example.SpelProject.data.User;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class AppExpressionParser {
    public static void main(String[] args) {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression exp1 = parser.parseExpression("'Hello World'");
        String message = (String) exp1.getValue();
        System.out.println(message);

        Expression exp2= parser.parseExpression("'Hello World'.length()");
        System.out.println(exp2.getValue());

        Expression exp3=parser.parseExpression("'Hello World'.length()*10");

        System.out.println(exp3.getValue());


        Expression exp4 = parser.parseExpression("'Hello World'.length()>10");
        System.out.println(exp4.getValue());

        Expression exp5 = parser.parseExpression("'Hello World'.length()>10 and 'Hello World'.length()<20");
        System.out.println(exp5.getValue());

        StandardEvaluationContext ec1 = new StandardEvaluationContext();
        ec1.setVariable("greeting", "Hello USA");
        String msg = (String) parser.parseExpression("#greeting.substring(6)").getValue(ec1);

        StandardEvaluationContext ec2 = new StandardEvaluationContext();
        ec2.setVariable("greeting","Hello UK");

        String msg2 = (String) parser.parseExpression("#greeting.substring(6)").getValue(ec2);
        System.out.println(msg2);
        System.out.println("####################");


        /*


         */
        User user = new User();
        /*
        root object of StandardEvaluationContext by pasing Construcotr , use spel to wire the property :
         */
        StandardEvaluationContext userContext = new StandardEvaluationContext();
        /*
        pass the value
         */
        parser.parseExpression("country").setValue(userContext,"USA");

        System.out.println(user.getCountry());

        parser.parseExpression("language").setValue(userContext,"en");
        System.out.println(user.getLanguage());


        parser.parseExpression("timeZone").setValue(userContext,"America/New_York");
        System.out.println(user.getTimeZone());





    }
}
