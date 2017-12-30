# Introduction

The quality of recommendations is largely determined by the quantity and quality of data. Garbage in, garbage out was never truer than here. Likewise, recommender algorithms are data intensive, and runtime performance is greatly affected by quantity and representation of data. This article explores classes in Mahout for representing and accessing recommender-related data.

The input to a recommender engine is preference data—who likes what and how much. So, the input to Mahout recommenders is simply a set consisting of user ID, item ID, and preference value tuples—a large set, of course. Sometimes, even preference values are omitted.

# References

https://javabeat.net/preference-object-in-mahout/

http://mahout.apache.org/users/recommender/recommender-documentation.html

http://h2database.com/javadoc/org/h2/jdbcx/JdbcDataSource.html
