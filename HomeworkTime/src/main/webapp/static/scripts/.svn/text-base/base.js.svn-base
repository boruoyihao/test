requirejs.config({
    baseUrl: '/static/scripts/lib',

    paths: {
        apps: '../apps',
        modules: '../modules',
        jquery: 'jquery/jquery-1.11.1.min',
        'jquery-ui': 'jqueryui/jquery-ui.min',
        bootstrap: 'bootstrap/bootstrap.min',
        handlebars: 'handlebars/handlebars.runtime-v1.3.0.min',
        templates: '../templates/templates'
    },

    shim: {
        'jquery-ui': {
            exports: 'jqueryui',
            deps: ['jquery']
        },
        bootstrap: {
            exports: 'bootstrap'
        },
        handlebars: {
            exports: 'handlebars'
        },
        templates: {
            deps: ['handlebars'],
            exports: 'templates'
        }
    }
});
