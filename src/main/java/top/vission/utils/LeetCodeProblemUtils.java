package top.vission.utils;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;

import java.util.*;

@Slf4j
public class LeetCodeProblemUtils {
    public static Map<String, LeetCodeProblemRun> problemMap = new HashMap<>();

    public LeetCodeProblemUtils() {
        init();
    }

    public LeetCodeProblemRun getProblemById(String problemId) {
        return problemMap.get(problemId);
    }

//    public List<LeetCodeProblemRun> getProblemsByIds(List<String> problemIds) {
//        List<LeetCodeProblemRun> problems = new ArrayList<>();
//        for (String problemId : problemIds) {
//            if (problemMap.containsKey(problemId)) {
//                problems.add(problemMap.get(problemId));
//            }
//        }
//        return problems;
//    }

    private void init() {
        Set<Class<?>> classes = ClassUtil.scanPackage("top.vission.problems.impl");
        for (Class<?> problemClass : classes) {
            try {
                LeetCodeProblemRun problem = (LeetCodeProblemRun) problemClass.getConstructor().newInstance();
                String simpleName = problemClass.getSimpleName();
                String problemId = StrUtil.removePrefix(simpleName, "P");
                problemMap.put(problemId, problem);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
