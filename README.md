# MyBatis分页插件扩展，可以让mapper直接返回PageInfo #

### MyBatis PageHelperExt ###

[![Build Status](https://travis-ci.org/mybatis/mybatis-3.svg?branch=master)](https://travis-ci.org/mybatis/mybatis-3)
[![Coverage Status](https://coveralls.io/repos/mybatis/mybatis-3/badge.svg?branch=master&service=github)](https://coveralls.io/github/mybatis/mybatis-3?branch=master)
[![Dependency Status](https://www.versioneye.com/user/projects/56199c04a193340f320005d3/badge.svg?style=flat)](https://www.versioneye.com/user/projects/56199c04a193340f320005d3)
[![Maven central](https://maven-badges.herokuapp.com/maven-central/org.mybatis/mybatis/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.mybatis/mybatis)
[![License](http://img.shields.io/:license-apache-brightgreen.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)
[![Stack Overflow](http://img.shields.io/:stack%20overflow-mybatis-brightgreen.svg)](http://stackoverflow.com/questions/tagged/mybatis)
[![Project Stats](https://www.openhub.net/p/mybatis/widgets/project_thin_badge.gif)](https://www.openhub.net/p/mybatis)

![mybatis](http://mybatis.github.io/images/mybatis-logo.png)

----------

## Document: ##
	
----------

	描述：基于MyBatis分页插件（https://github.com/pagehelper/Mybatis-PageHelper），可以让mapper直接返回PageInfo而不用做二次转换。

----------
### 1. 配置说明 ###

	pom.xml
		<dependency>
			<groupId>com.chrhc.mybatis</groupId>
			<artifactId>PageHelperExt</artifactId>
			<version>0.0.1</version>
		</dependency>
----------
	mybatis-config.xml
	
	<objectFactory type="com.chrhc.mybatis.pagehelper.ext.PageObjectFactory" />
	
	<objectWrapperFactory type="com.chrhc.mybatis.pagehelper.ext.PageObjectWrapperFactory" />
	
	<plugins>
	    <plugin interceptor="com.github.pagehelper.PageHelper">
	        <property name="reasonable" value="true"/>
	        <property name="supportMethodsArguments" value="true"/>
	    </plugin>
	</plugins>

----------

### 2.关于作者： ###
	作者QQ：605162215
	作者邮箱：605162215@qq.com
