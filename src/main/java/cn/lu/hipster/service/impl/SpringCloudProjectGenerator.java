package cn.lu.hipster.service.impl;

import cn.lu.hipster.api.MybatisGenerator;
import cn.lu.hipster.api.SpringCloudGenerator;
import cn.lu.hipster.api.SpringCloudMVCGenerator;
import cn.lu.hipster.model.GeneratorParam;
import cn.lu.hipster.service.ProjectGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 生成SpringBoot项目
 *
 * @author lutiehua
 * @date 2018-12-03
 */
@Component("springCloudProjectGenerator")
public class SpringCloudProjectGenerator implements ProjectGenerator {

    @Autowired
    private SpringCloudGenerator projectGenerator;

    @Autowired
    private MybatisGenerator mybatisGenerator;

    @Autowired
    private SpringCloudMVCGenerator springMVCGenerator;

    @Override
    public String generateProject(GeneratorParam generatorParam) throws Exception {
        // 生成项目
        projectGenerator.generateCode(generatorParam);

        // 生成CRUD
        mybatisGenerator.generateCode(generatorParam);

        // 生成Controller/Service/Model
        springMVCGenerator.generateCode(generatorParam);

        String message = String.format("成功生成项目到\"%s\"目录下", generatorParam.getPackageInfo().getProjectPath());
        return message;
    }
}