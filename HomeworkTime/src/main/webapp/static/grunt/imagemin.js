module.exports = {
    optimize: {
        options: {
            optimizationLevel: 3
        },

        files: [{
            expand: true,
            cwd: 'assets/images',
            src: ['**/*.{png,jpg,gif}'],
            dest: 'dist/assets/images'
        }]
    }
};
