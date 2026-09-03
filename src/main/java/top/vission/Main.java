package top.vission;

import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;
import top.vission.problems.enums.LeetCodeProblemEnum;
import top.vission.utils.LeetCodeProblemUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {

        List<String> problemIds = new ArrayList<>();
        problemIds.add("242");
        problemRunTemplate(problemIds);
    }

    private static void problemRunTemplate(List<String> problemIds) {
        LeetCodeProblemUtils problemUtils = new LeetCodeProblemUtils();

        for (String problemId : problemIds) {
            LeetCodeProblemRun problem = problemUtils.getProblemById(problemId);
            if (problem == null) {
                log.error("缺失题号:LeetCode{}",problemId);
                continue;
            }
            LeetCodeProblemEnum problemEnum = LeetCodeProblemEnum.getById(problemId);
            log.info("====================");
            log.info("-----当前执行题号：LeetCode{},{}-----", problemEnum.getId(), problemEnum.getName());
            log.info("-----问题描述：{}-----", problemEnum.getDescription());
            log.info("====================");
            problem.run();
            log.info("====================");
        }
    }



}
