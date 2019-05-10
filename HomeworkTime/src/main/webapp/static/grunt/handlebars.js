module.exports = {

    compile: {
        options: {
            namespace: 'JIT',
            partialsUseNamespace: true
        },

        files: {
            'scripts/templates/templates.js': ['templates/**/*.hbs']
        }
    }

};
