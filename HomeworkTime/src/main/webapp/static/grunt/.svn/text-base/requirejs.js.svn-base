module.exports = {
    build: {
        options: {
            baseUrl: './scripts/lib',
            appDir: './',
            mainConfigFile: './scripts/base.js',
            dir: './app-built',
            fileExclusionRegExp: /(^\.|node_modules|grunt|sass)/,
            preserveLicenseComments: false,
            // optimize: 'none',
            optimizeCss: 'standard',
            // findNestedDependencies: true,

            modules: [
                {
                    name: '../base',
                    include: [
                        'jquery',
                        'jquery-ui',
                        'bootstrap',
                        'handlebars',
                        'templates'
                    ]
                },

                // 注册
                {
                    name: 'apps/register',
                    exclude: ['../base']
                },

                // 交易查询
                {
                    name: 'apps/tradeQuery',
                    exclude: ['../base']
                }
            ]

        }
    }
};
