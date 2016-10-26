package com.rburdo.coding.rea.robot.main;


import com.rburdo.coding.rea.robot.RobotOperator;
import com.rburdo.coding.rea.robot.RobotOperatorFactory;
import com.rburdo.coding.rea.robot.impl.input.InputStreamRobotCommandFactoryFactory;
import com.rburdo.coding.rea.robot.impl.output.OutputStreamReportPresenterFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileInputStream;
import java.io.InputStream;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
        if (args.length > 1) {
            System.err.println("Format : run.bat <commands file> ");
            exit(1);
        }

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        RobotOperatorFactory operatorFactory = ctx.getBean(RobotOperatorFactory.class);
        OutputStreamReportPresenterFactory presenterFactory = ctx.getBean(OutputStreamReportPresenterFactory.class);
        InputStreamRobotCommandFactoryFactory commandFactoryFactory = ctx.getBean(InputStreamRobotCommandFactoryFactory.class);

        try {
            InputStream inputStream = (args.length == 1 ? new FileInputStream(args[0]) : System.in);
            RobotOperator operator = operatorFactory.create(
                    commandFactoryFactory.create(inputStream), presenterFactory.create());

            if (inputStream.equals(System.in)) {
                System.out.println("Please enter your commands:");
            }
            operator.batchExecute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
