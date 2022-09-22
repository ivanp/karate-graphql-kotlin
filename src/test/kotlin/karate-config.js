function fn() {
    var env = karate.env; // get system property 'karate.env'
    karate.log('karate.env system property was:', env);
    if (!env) {
        env = 'dev';
    }
    var config = {
        starWarsUrl: "https://swapi-graphql.netlify.app/.netlify/functions/index"
    }
    karate.configure('connectTimeout', 20000);
    karate.configure('readTimeout', 20000);
    karate.configure('ssl', true)
    return config;
}