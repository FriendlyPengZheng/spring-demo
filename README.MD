**成就经历简述**\
2020.2.10-2020.5.20，在***有限公司与团队一起完成了日志中心建设，提升了公司日志的查询，故障发现及处理的效率。\
**Situation:**\
1.****有限公司有包括官网，游戏app，电商app，公众号后台，redis等存储系统及服务后台，日志需要采集及统一处理。\
2.需要提供一个便于部署的日志采集agent，实时采集日志。支持8w+条/s数据量。\
3.要设计提供一个统一的日志检索中心，方便用户查询日志，避免登陆机器查询。\
4.需要设计一个规则引擎，用户便捷的编写规则，然后实时对日志数据执行规则，及时发现日志异常，以便及时处理。\
5.需要建设告警系统，实现同比，环比，频率等功能，相同告警的统计及合并告警，减少无效告警次数。\
6.采集系统部署，规则配置，告警配置，日志检索，需要设计一个统一的UI，增加用户权限管理功能。\
**Task：**\
团队的任务与目标：
1.设计一个日志采集器，实时采集应用日志，上报到kafka。\
2.调研设计规则引擎，规则编写要简单，支持语法要多样，要利用现有实时计算平台，如flink。\
3.调研设计告警系统，支持同比，环比，循环，频率，固定间隔及告警聚合统计功能，减少无效告警，并且告警要实时。\
4.设计web UI及相应后台，方便用户一键部署采集系统，下发日志规则及告警规则和便捷的查询日志定位问题。 \
**我的任务及目标**\
1.调研用户规则编写的需求。\
2.调研现有的规则引擎，根据用户的需求选择最恰当的作为基础规则引擎。\
3.设计规则引擎的实现内核架构，整合实时计算引擎。\
4.部署，测试，压测规则引擎，针对性能优化，使其满足性能需求。\
5.编写脚本实现规则引擎故障自动拉起。 \
**Action：**\
**我的工作及任务：**\
1.用了两天时间，调研，收集用户的日志规则需求。\
2.花了一周时间，调研，对比现有的规则引擎，easyrules，groovy，drools等。最后根据语法编写复杂度，性能等，确定利用groovy来实现自己的规则引擎。\
3.用三天时间，实现对groovy作为规则引擎细致调研，设计groovy作为规则引擎的整体架构及确定与flink整合的方案。\
4.花一周时间，完成规则引擎的核心代码，成功整合flink。\
5.花三天时间，进行初步的测试，压测及调优，同时完成监控脚本的编写。\
**Result：**\
**项目整体成果：**\
经过两个月的努力，完成了公司的日志中心的全部功能，有了规则引擎及告警系统，应用的异常能够及时发现并告警，提升了处理异常的效率，利用日志中心大大提升了用户日志检索排查的效率。 \
**我的成果：**\
1.独立调研，设计，实现了实时规则引擎系统。\
2.规则下发实时生效。\
3.目前以及支持2k+规则，每秒钟处理数据量 1w条。\
4.辅助公司发现应用异常若干，避免了巨大故障带来的损失。\
5.过程中进一步掌握的技术有订阅发布系统Apollo，flink，多线程，groovy内核，并发集合等等。\
