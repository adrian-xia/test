/**
 * 第二章 装配bean
 * Created by xialei on 2017/3/9.
 *
 *
 * org.springframework.context.support.AbstractApplicationContext#obtainFreshBeanFactory()
 * 此处将xml文件解析，并加载到beanfactory的map中
 * org.springframework.context.support.AbstractApplicationContext#finishBeanFactoryInitialization(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
 * 在此将解析的文件，以及各种bean进行初始化
 */
package spring.test.sa.chapter02;