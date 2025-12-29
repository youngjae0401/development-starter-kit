import js from '@eslint/js'
import globals from 'globals'
import reactHooks from 'eslint-plugin-react-hooks'
import reactRefresh from 'eslint-plugin-react-refresh'
import react from 'eslint-plugin-react'
import importPlugin from 'eslint-plugin-import'
import tseslint from 'typescript-eslint'
import prettierConfig from 'eslint-config-prettier'

export default tseslint.config(
    // 빌드 결과물 무시
    {
        ignores: ['dist', 'build'],
    },

    // JavaScript 기본 설정
    js.configs.recommended,

    // TypeScript 권장 설정
    ...tseslint.configs.recommended,

    // Prettier와 충돌하는 규칙 비활성화
    prettierConfig,

    // TypeScript + React 설정
    {
        files: ['**/*.{ts,tsx}'],

        languageOptions: {
            ecmaVersion: 2020,
            globals: globals.browser,
            parserOptions: {
                ecmaFeatures: {
                    jsx: true,
                },
            },
        },

        settings: {
            react: {
                version: 'detect',
            },
        },

        plugins: {
            react,
            'react-hooks': reactHooks,
            'react-refresh': reactRefresh,
            import: importPlugin,
        },

        rules: {
            /* -----------------------------
             * React / Hooks
             * ----------------------------- */
            ...reactHooks.configs.recommended.rules,

            'react/react-in-jsx-scope': 'off', // React 17+
            'react/jsx-uses-react': 'off',

            'react-refresh/only-export-components': [
                'warn',
                {allowConstantExport: true},
            ],

            /* -----------------------------
             * TypeScript
             * ----------------------------- */
            '@typescript-eslint/no-unused-vars': [
                'warn',
                {argsIgnorePattern: '^_'},
            ],
            '@typescript-eslint/no-explicit-any': 'off',

            /* -----------------------------
             * Import 정렬
             * ----------------------------- */
            'import/order': [
                'warn',
                {
                    groups: [
                        'builtin',
                        'external',
                        'internal',
                        'parent',
                        'sibling',
                        'index',
                        'object',
                        'type',
                    ],
                    'newlines-between': 'always',
                    alphabetize: {
                        order: 'asc',
                        caseInsensitive: true,
                    },
                },
            ],
        },
    },
)
