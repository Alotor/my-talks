# Understanding GORM (Greach 2014)
In this talk I summary some of the key concepts inside GORM and show some of the common pitfalls and
how not to got them.

## Compiling slides
``
grunt serve
``
After that access http://localhost:8000 to see the slides.

## Pitfalls examples
``
grails test-app integration:
``

To see the fixes to the failing pitfalls checkout the branch 'pitfalls fixed'

``
git checkout pitfalls_fixed
``

## References
http://schneide.wordpress.com/2011/04/05/grails-the-good-the-bad-the-ugly/
http://schneide.wordpress.com/2013/08/12/grails-gorm-performance-tuning-tips/
http://www.anyware.co.uk/2005/2012/11/12/the-false-optimism-of-gorm-and-hibernate/
http://viralpatel.net/blogs/introduction-to-hibernate-framework-architecture/
https://developer.atlassian.com/display/CONFDEV/Hibernate+Session+and+Transaction+Management+for+Bulk+Operations
http://howtodoinjava.com/2013/07/01/understanding-hibernate-first-level-cache-with-example/
http://docs.jboss.org/hibernate/orm/3.6/reference/en-US/html_single/#transactions-basics
http://grails.org/doc/latest/guide/conf.html#configGORM
http://www.slideshare.net/mrfritz379/standalone-gorm
http://grails.org/doc/2.3.x/ref/Plug-ins/domainClasses.html
http://grails.io/post/45774038833/road-to-grails-2-3-async-support
http://grails.org/doc/2.3.4/ref/Database%20Mapping/dynamicUpdate.html
http://www.infoq.com/presentations/GORM-Performance
http://www.infoq.com/presentations/grails-transaction
http://blog.octo.com/en/transactions-in-grails/
https://community.jboss.org/wiki/OpenSessioninView
http://sacharya.com/tag/gorm-transaction/
