use std::io::{self, BufRead};

struct Quizzer<R, W> {
    reader: R,
    writer: W,
}

impl<R, W> Quizzer<R, W>
    where
        R: BufRead,
        W: Write,
{
    fn prompt(&mut self, question: &str) -> String {
        write!(&mut self.writer, "{}", question).expect("Unable to write");
        let mut s = String::new();
        self.reader.read_line(&mut s).expect("Unable to read");
        s
    }
}

fn main() {
    let stdio = io::stdin();
    let input = stdio.lock();

    let output = io::stdout();

    let mut quizzer = Quizzer {
        reader: input,
        writer: output,
    };

    let answer = quizzer.prompt("Who goes there?");
    println!("was: {}", answer);
}