module.exports = {
    htmlhint: {
        files: '../*.html',
        tasks: ['htmlhint']
    },

    handlebars: {
        files: ['templates/**/*.hbs'],
        tasks: ['handlebars']
    },

    compass: {
        files: ['sass/**/*.scss'],
        tasks: ['compass']
    },

    jshint: {
        files: ['scripts/**/*.js', '!scripts/lib/**/*.js'],
        tasks: ['jshint']
    }
};
