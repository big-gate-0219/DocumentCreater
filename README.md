## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## settings

*.vscode/settings*
```json
{
    "java.project.sourcePaths": ["src"],
    "java.project.outputPath": "bin",
    "java.project.referencedLibraries": [
        "lib/**/*.jar"
    ]
}
```

## Markdown Preview Enhanced: Custmize CSS

*.markdown-preview.markdown-preview*
```css
.markdown-preview.markdown-preview {

  h1 {
    padding: 0.4em 0.5em;/*文字の上下 左右の余白*/
    color: #494949;/*文字色*/
    background: #f4f4f4;/*背景色*/
    border-left: solid 5px #7db4e6;/*左線*/
    border-bottom: solid 3px #d7d7d7;/*下線*/
  }

  h2 {
    position: relative;
    padding: 0.5em;
    background: #7db4e6;
    color: black;
  }

  h2::before {
    position: absolute;
    content: '';
    top: 100%;
    left: 0;
    border: none;
    border-bottom: solid 15px transparent;
    border-right: solid 20px rgb(149, 158, 155);
  }

  h3 {
    position: relative;
  }

  h3::before {
    position: absolute;
    bottom: 0;
    content: '';
    width: 100%;
    border-bottom: 3px solid lightblue;
  }
}
```